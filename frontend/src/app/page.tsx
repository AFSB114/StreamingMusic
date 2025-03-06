"use client";

import { useState, useEffect } from "react";
import Song from "@/components/Song";
import { getMusics } from "@/services/musics";

export default function Home() {
  let count = 0;

  const [musics, setMusics] = useState([]);

  useEffect(() => {
    getMusics().then((data) => {
      setMusics(data);
    });
  }, []);

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm grid md:grid-cols-3 lg:grid-cols-5  gap-3">
      {musics.map((song, index) => (
        <Song key={index} song={song} />
      ))}
    </div>
  );
}
