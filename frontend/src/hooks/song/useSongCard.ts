"use client";

import { useState } from "react";
import { useSongsList } from "@/hooks";
import type { SongType } from "@/types";

export default function useSongCard({ song }: { song: SongType }) {
  const { deleteSong } = useSongsList();
  const [liked, setLiked] = useState(false);

  const handleLike = () => {
    setLiked(!liked);
  };

  const handleDelete = () => {
    deleteSong(song.id);
  };

  return { handleLike, handleDelete, liked };
}
