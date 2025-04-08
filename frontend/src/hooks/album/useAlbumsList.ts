import { useContext } from "react";
import type { AlbumContextType } from "@/types";
import { AlbumContext } from "@/context/AlbumContext";

export default function useAlbumsList(): AlbumContextType {
  const context = useContext(AlbumContext);
  if (!context) {
    throw new Error("useAlbum must be used within a AlbumProvider");
  }
  return context;
}