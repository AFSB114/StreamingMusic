"use client";

import { useReducer, useCallback, useEffect } from "react";
import { entityReducer } from "@/reducers/entityReducer";
import {  Response } from "@/types";

export default function useEntity<T extends { id: number }>(apiUrl: string) {
  const [state, dispatch] = useReducer(entityReducer<T>, []);

  const fetchEntities = useCallback(async () => {
    try {
      const res = await fetch(`${apiUrl}/`);
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

  const addEntity = useCallback(async (newEntity: Partial<T>) => {
    try {
      const res = await fetch(`${apiUrl}/`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newEntity),
      });
      if (!res.ok) throw new Error("Error adding entity");
      const addedEntity: Response<T> = await res.json();
      dispatch({ type: "ADD", payload: addedEntity });
    } catch (error) {
      console.error(error);
    }
  }, [apiUrl]);

  const updateEntity = useCallback(async (id: number, updatedEntity: Partial<T>) => {
    try {
      const res = await fetch(`${apiUrl}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updatedEntity),
      });
      if (!res.ok) throw new Error("Error updating entity");
      const updatedData: Response<T> = await res.json();
      dispatch({ type: "UPDATE", payload: { id, updatedEntity: updatedData } });
    } catch (error) {
      console.error(error);
    }
  }, [apiUrl]);

  const deleteEntity = useCallback(async (id: number) => {
    try {
      const response = await fetch(`${apiUrl}/${id}`, {
        method: "DELETE",
      });
      if (!response.ok) throw new Error("Error deleting entity");
      dispatch({ type: "DELETE", payload: id });
    } catch (error) {
      console.error(error);
    }
  }, [apiUrl]);

  const getEntityById = useCallback((id: number) => {
    return state.find((item) => item.id === id) || null;
  }, [state]);

  const searchEntityBy = useCallback(async (params: Record<string, string>) => {
    const res = await fetch(`${apiUrl}/search?${new URLSearchParams(params)}`);
    if (!res.ok) throw new Error("Error fetching entity by filter");
    const data: Response<T> = await res.json();    
    dispatch({ type: "SEARCH", payload: data });

  }, [apiUrl]);

  return { state, addEntity, deleteEntity, updateEntity, getEntityById, fetchEntities, searchEntityBy };
};
