"use client";

import { useState, useEffect } from "react";

import { Heart, Music } from "lucide-react";
import Image from "next/image";

export default function Song({ song }: { song: any }) {
  const [liked, setLiked] = useState(false);

  useEffect(() => {
    setLiked(false);
  }, []);

  const handleLike = () => {
    setLiked(!liked);
  };

  function formatDuration(duration: number) {
    const minutes = Math.floor(duration / 60);
    const seconds = duration % 60;
    return `${minutes}:${seconds < 10 ? "0" : ""}${seconds}`;
  }

  return (
    <div className="w-full box-border rounded-md border-2 border-zinc-800 bg-zinc-900 p-3 shadow-sm hover:border-red-500 hover:shadow-md transition-all duration-200">
      <div className="relative">
        <Image
          src={`${song.image[2]["#text"]}`}
          alt="Album cover"
          width={300}
          height={300}
          className="object-cover"
        />
      </div>
      {/* Header */}
      <div className="p-3">
        <div className="flex justify-between items-center">
          <div>
            <h3 className="text-base">{song.name}</h3>
            <p className="text-xs">{song.artist.name}</p>
          </div>
          <button
            type="button"
            onClick={handleLike}
            className={`flex items-center gap-2 rounded-full p-2 transition-all duration-150 ${
              liked ? "bg-red-500/80 ease-in" : "ease-out"
            }`}
          >
            <Heart className={`h-5 w-5 active:scale-150 transition-all duration-150 ${liked ? "active:text-white" : "active:text-red-500"}`} />
            <span className="sr-only">Like</span>
          </button>
        </div>
      </div>
      {/* Footer */}
      <div className="p-3 pt-0 text-xs text-muted-foreground">
        <div className="flex items-center gap-1">
          <Music className="h-3 w-3" />
          <span>{ formatDuration(song.duration) }</span>
        </div>
      </div>
    </div>
  );
}
