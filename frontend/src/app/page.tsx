"use client";

import { useState, useEffect } from "react";
import Song from "@/components/Song";
import { getMusics } from "@/services/musics";

export default function Home() {
  const [musics, setMusics] = useState([]);

  useEffect(() => {
    getMusics().then((data) => {
      setMusics(data);
    });
  }, []);

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-5 bg-zinc-900 p-6 rounded-2xl ">
      {
        musics.map((song, index) => (
        <Song key={index} song={song} />
      ))}
    </div>
  );
}
