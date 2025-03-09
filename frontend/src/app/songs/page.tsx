"use client";

import { useMusic } from "@/context/MusicContext";  // Importa desde el contexto
import Song from "@/components/Song";

export default function SongPage() {
  const { musics } = useMusic();  // Usa el contexto compartido

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm grid md:grid-cols-3 lg:grid-cols-5 gap-3">
      {musics.map((song, index) => (
        <Song key={index} song={song} />
      ))}
    </div>
  );
}