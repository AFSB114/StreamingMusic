"use client";

import AlbumCard from "@/components/AlbumCard";
import { useAlbumsList } from "@/hooks";
import { PlusCircle, Search } from "lucide-react";
import Link from "next/link";

export default function Albums() {
  const { albumsList } = useAlbumsList();

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm">
      <div className="sticky top-0 z-40 flex justify-between items-center mb-5 bg-zinc-900 p-2 rounded-lg shadow-lg">
        <div className="w-max">
          <Link href="/sections/albums/add">
            <button className="text-1xl sm:text-2xl gap-2 rounded-xl flex flex-row items-center justify-center transition-colors duration-200 hover:bg-green-600 p-3 hover:cursor-pointer">
              <PlusCircle className="h-6 w-6" />
              <span>Add Album</span>
            </button>
          </Link>
        </div>
        <form className="flex gap-2 items-center">
          <div>
            <button
              type="submit"
              className="text-1xl sm:text-2xl rounded-xl flex flex-row items-center justify-center transition-colors duration-200 hover:bg-red-800 p-3 hover:cursor-pointer"
            >
              <Search className="h-6 w-6" />
            </button>
          </div>
          <div>
            <input
              type="text"
              id="search"
              name="search"
              placeholder="Search..."
              className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            />
          </div>
          <div>
            <select
              name="type"
              id="type"
              className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            >
              <option value="">Select Type</option>
              <option value="Solo">Solo</option>
              <option value="Band">Band</option>
              <option value="Group">Group</option>
            </select>
          </div>
        </form>
      </div>

      <div className="grid sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-3">
        {albumsList
          .sort((a, b) => a.id - b.id)
          .map((album) => (
          <AlbumCard album={album} key={album.id} />
        ))}
      </div>
    </div>
  );
}
