"use client";

import { useState } from "react";
import { useSongsList } from "@/hooks/useSongsList";
import type { songType } from "@/types";

export default function useSongCard({ song }: { song: songType }) {
  const { deleteSong } = useSongsList();
  const [liked, setLiked] = useState(false);

  const handleLike = () => {
    setLiked(!liked);
  };

  const handleDelete = () => {
    deleteSong(song.id);
  };

  function formatDuration(duration: number) {
    const minutes = Math.floor(duration / 60);
    const seconds = duration % 60;
    return `${minutes}:${seconds < 10 ? "0" : ""}${seconds}`;
  }

  return { handleLike, handleDelete, liked, formatDuration };
}
