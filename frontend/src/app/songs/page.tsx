"use client";

import { useSongsList } from "@/hooks/useSongsList";
import Song from "@/components/SongCard";

export default function SongPage() {
  const { songsList } = useSongsList(); // Usa el contexto compartido

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm grid md:grid-cols-3 lg:grid-cols-5 gap-3">
      {songsList.map((song, index) => (
        <Song key={index} song={song} />
      ))}
    </div>
  );
}
