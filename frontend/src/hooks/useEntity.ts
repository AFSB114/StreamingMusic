import { useReducer, useCallback } from "react";
import { entityReducer } from "@/reducers/entityReducer";

export const useEntity = <T extends {id: number}>(initialState: T[]) => {
  const [state, dispatch] = useReducer(entityReducer<T>, initialState);

  const addEntity = useCallback((newEntity: Omit<T, "id">) => {
    dispatch({ type: "ADD", payload: newEntity });
    return newEntity.id;
  }, []);

  const deleteEntity = useCallback((id: number) => {
    dispatch({ type: "DELETE", payload: id });
  }, []);

  const updateEntity = useCallback((id: number, updatedEntity: Partial<T>) => {
    dispatch({ type: "UPDATE", payload: { id, updatedEntity } });
  }, []);

  const getEntityById = useCallback((id: number) => {
    return state.find(item => item.id === id) || null;
  }, [state]);

  return { state, addEntity, deleteEntity, updateEntity, getEntityById };
};
