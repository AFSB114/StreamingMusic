"use client";

import Link from "next/link";
import { useSongsList } from "@/hooks/useSongsList";
import SongCard from "@/components/SongCard";
import { Disc3 } from "lucide-react";

export default function SongPage() {
  const { songsList } = useSongsList(); // Usa el contexto compartido

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm ">
      <Link href="/songs/add">
        <button className="text-2xl flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-3 mb-5 hover:cursor-pointer">
          <Disc3 className="h-6 w-6" />
          <span>Añadir canción</span>
        </button>
      </Link>
      <div className="grid md:grid-cols-3 lg:grid-cols-5 gap-3">
        {songsList.map((song, index) => (
          <SongCard key={index} song={song} />
        ))}
      </div>
    </div>
  );
}
