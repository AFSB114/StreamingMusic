import { useContext } from "react";
import type { UserContextType } from "@/types";
import { UserContext } from "@/context/UserContext";

export default function useSongsList(): UserContextType {
  const context = useContext(UserContext);
  if (!context) {
    throw new Error("useSong must be used within a SongProvider");
  }
  return context;
};