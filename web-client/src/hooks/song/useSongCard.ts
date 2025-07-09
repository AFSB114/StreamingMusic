"use client";

import { useSongsList } from "@/hooks";

export default function useSongCard({ id }: {id: number}) {
  const { deleteSong } = useSongsList();

  const handleDelete = () => {
    deleteSong(id);
  };

  return { handleDelete };
}
