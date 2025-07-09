import { useContext } from "react";
import type { ArtistContextType } from "@/types";
import { ArtistContext } from "@/context/ArtistContext";

export default function useArtistsList(): ArtistContextType {
  const context = useContext(ArtistContext);
  if (!context) {
    throw new Error("useArtist must be used within a ArtistProvider");
  }
  return context;
}
