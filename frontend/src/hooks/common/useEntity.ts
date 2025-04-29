"use client";

import { entityReducer } from "@/reducers/entityReducer";
import { Response } from "@/types";
import { useRouter } from "next/navigation";
import { useCallback, useEffect, useReducer } from "react";

export default function useEntity<T extends { id: number }>(apiUrl: string, section: string) {
  const [state, dispatch] = useReducer(entityReducer<T>, []);
  const router = useRouter();

  const fetchEntities = useCallback(async () => {
    try {
      const res = await fetch(`${apiUrl}/`, {
        headers: { "AUTH-KEY": "159753258456" },
      });
      if (!res.ok) throw new Error("Error fetching entities");
      const data: T[] = await res.json();
      dispatch({ type: "GET", payload: data });
    } catch (error) {
      console.error(error);
    }
  }, [apiUrl]);

  useEffect(() => {
    fetchEntities();
  }, [fetchEntities]);

  const addEntity = useCallback(
    async (newEntity: Partial<T>) => {
      try {
        const res = await fetch(`${apiUrl}/`, {
          method: "POST",
          headers: { "AUTH-KEY": "159753258456" , "Content-Type": "application/json" },
          body: JSON.stringify(newEntity),
        });
        if (!res.ok) {
          alert("Error adding entity");
          const response = await res.json();

          for (const error of response.errors) {
            alert(error);
          }

          return;
        };
        const addedEntity: Response<T> = await res.json();
        dispatch({ type: "ADD", payload: addedEntity });
        router.push(`/sections/${section}}`);
      } catch (error) {
        console.error(error);
      }
    },
    [apiUrl, section, router]
  );

  const updateEntity = useCallback(
    async (id: number, updatedEntity: Partial<T>) => {
      try {
        const res = await fetch(`${apiUrl}/${id}`, {
          method: "PUT",
          headers: { "AUTH-KEY": "159753258456" , "Content-Type": "application/json"},
          body: JSON.stringify(updatedEntity),
        });
        if (!res.ok) throw new Error("Error updating entity");
        const updatedData: Response<T> = await res.json();
        dispatch({
          type: "UPDATE",
          payload: { id, updatedEntity: updatedData },
        });
      } catch (error) {
        console.error(error);
      }
    },
    [apiUrl]
  );

  const deleteEntity = useCallback(
    async (id: number) => {
      try {
        const response = await fetch(`${apiUrl}/${id}`, {
          method: "DELETE",
          headers: { "AUTH-KEY": "159753258456" },
        });
        if (!response.ok) throw new Error("Error deleting entity");
        dispatch({ type: "DELETE", payload: id });
      } catch (error) {
        console.error(error);
      }
    },
    [apiUrl]
  );

  const getEntityById = useCallback(
    (id: number) => {
      return state.find((item) => item.id === id) || null;
    },
    [state]
  );

  const searchEntityBy = useCallback(
    async (params: Record<string, string>) => {
      const res = await fetch(
        `${apiUrl}/search?${new URLSearchParams(params)}`,
        {
          headers: { "AUTH-KEY": "159753258456" },
        }
      );
      if (!res.ok) throw new Error("Error fetching entity by filter");
      const data: Response<T> = await res.json();
      dispatch({ type: "SEARCH", payload: data });
    },
    [apiUrl]
  );

  return {
    state,
    addEntity,
    deleteEntity,
    updateEntity,
    getEntityById,
    fetchEntities,
    searchEntityBy,
  };
}
