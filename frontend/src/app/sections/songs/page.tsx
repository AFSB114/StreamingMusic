"use client";

import Link from "next/link";
import { useSongsList } from "@/hooks";
import SongCard from "@/components/SongCard";
import { PlusCircle } from "lucide-react";

export default function SongPage() {
  const { songsList } = useSongsList();

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm">
      <div className="sticky top-0 z-40 flex justify-between items-center mb-5 bg-zinc-900 p-2 rounded-lg shadow-lg">
        <div className="w-max">
          <Link href="/sections/songs/add">
            <button className="text-1xl sm:text-2xl gap-2 rounded-xl flex flex-row items-center justify-center transition-colors duration-200 hover:bg-green-600 p-3 hover:cursor-pointer">
              <PlusCircle className="h-6 w-6" />
              <span>Add Song</span>
            </button>
          </Link>
        </div>
        <div className="flex gap-2">
          <input
            type="text"
            id="search"
            name="search"
            placeholder="Search..."
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700"
          />
        </div>
      </div>
      <div className="grid sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-5 gap-3">
        {songsList.map((song) => (
          <SongCard key={song.id} song={song} />
        ))}
      </div>
    </div>
  );
}
