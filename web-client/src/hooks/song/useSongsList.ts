import { useContext } from "react";
import type { SongContextType } from "@/types";
import { SongContext } from "@/context/SongContext";

export default function useSongsList(): SongContextType {
  const context = useContext(SongContext);
  if (!context) {
    throw new Error("useSong must be used within a SongProvider");
  }
  return context;
};