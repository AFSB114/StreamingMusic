"use client";

import { useSongsList } from "@/hooks";
import type { SongType } from "@/types";

export default function useSongCard({ song }: { song: SongType }) {
  const { deleteSong } = useSongsList();

  const handleDelete = () => {
    deleteSong(song.id);
  };

  return { handleDelete };
}
