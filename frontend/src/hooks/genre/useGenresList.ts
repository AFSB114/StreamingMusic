import { useContext } from "react";
import type { GenreContextType } from "@/types";
import { GenreContext } from "@/context/GenreContext";

export default function useGenresList(): GenreContextType {
  const context = useContext(GenreContext);
  if (!context) {
    throw new Error("useGenre must be used within a GenreProvider");
  }
  return context;
}