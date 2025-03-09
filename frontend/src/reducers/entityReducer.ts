import type { EntityAction } from "@/types";

export const entityReducer = <T>(state: T[], action: EntityAction<T>): T[] => {
  switch (action.type) {
    case "ADD": {
      const newId = state.length > 0 ? Math.max(...state.map(item => item.id)) + 1 : 1;
      return [...state, { ...action.payload, id: newId }];
    }
    case "DELETE":
      return state.filter(item => item.id !== action.payload);
    case "UPDATE":
      return state.map(item =>
        item.id === action.payload.id ? { ...item, ...action.payload.updatedEntity } : item
      );
    default:
      return state;
  }
};
