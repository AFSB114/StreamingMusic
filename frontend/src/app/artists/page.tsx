"use client";

import { useArtistsList } from "@/hooks/useArtistsList";
import ArtistCard from "@/components/ArtistCard";

export default function ArtistsPage() {
  const { artistsList } = useArtistsList(); // Usa el contexto compartido

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm grid md:grid-cols-3 lg:grid-cols-5 gap-3">
      {artistsList.map((artist, index) => (
        <ArtistCard key={index} artist={artist} />
      ))}
    </div>
  );
}
