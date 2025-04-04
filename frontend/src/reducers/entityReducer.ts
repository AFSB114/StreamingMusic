import type { EntityAction } from "@/types";

export const entityReducer = <T extends { id: number }>(
  state: T[],
  action: EntityAction<T>
): T[] => {
  switch (action.type) {
    case "GET":
      return action.payload;
    case "ADD":
      console.log(action.payload);
      return [...state, ...action.payload.data];
    case "UPDATE":
      return state.map((item) =>
        item.id === action.payload.id
          ? { ...item, ...action.payload.updatedEntity.data[0] }
          : item
      );
    case "DELETE":
      return state.filter((item) => item.id !== action.payload);
    case "SEARCH":
      return action.payload.data;
    default:
      return state;
  }
};
