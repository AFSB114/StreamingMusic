"use client";

import { useEffect, useState } from "react";
import Song from "@/components/Song";

import songs from "@/mocks/songs.json";

export default function Home() {
  const [musics, setMusics] = useState([]);

  useEffect(() => {
    setMusics(songs.songs);
  }, []);

  const deleteMusic = (id: number) => {
    setMusics((musics) => musics.filter((song) => song.id !== id));
  };

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm grid md:grid-cols-3 lg:grid-cols-5  gap-3">
      {musics.map((song, index) => (
        <Song key={index} song={song} deleteMusic={deleteMusic} />
      ))}
    </div>
  );
}
