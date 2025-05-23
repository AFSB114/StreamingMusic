"use client";

import ArtistCard from "@/components/ArtistCard";
import { artistTypes } from "@/constants";
import { useArtistsList, useFiltersArtist } from "@/hooks";
import { PlusCircle, Search } from "lucide-react";
import Head from "next/head";
import Link from "next/link";

export default function ArtistsPage() {
  const { artistsList } = useArtistsList(); // Usa el contexto compartido
  const { filters, handleChange, handleSubmit } = useFiltersArtist();

  return (
    <>
      <Head>
        <title>Artist</title>
      </Head>
      <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm">
        <div className="sticky top-0 z-40 flex justify-between items-center mb-5 bg-zinc-900 p-2 rounded-lg shadow-lg">
          <div className="w-max">
            <Link href="/sections/artists/add">
              <button className="text-1xl sm:text-2xl gap-2 rounded-xl flex flex-row items-center justify-center transition-colors duration-200 hover:bg-green-600 p-3 hover:cursor-pointer">
                <PlusCircle className="h-6 w-6" />
                <span>Add Artist</span>
              </button>
            </Link>
          </div>
          <form className="flex gap-2 items-center" onSubmit={handleSubmit}>
            <div>
              <button type="submit" className="text-1xl sm:text-2xl rounded-xl flex flex-row items-center justify-center transition-colors duration-200 hover:bg-red-800 p-3 hover:cursor-pointer">
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
                value={filters.search}
                onChange={handleChange}
              />
            </div>
            <div>
              <select
                name="type"
                id="type"
                className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
                value={filters.type}
                onChange={handleChange}
              >
                <option value="">
                  Select Type
                </option>
                {artistTypes.map((type) => (
                  <option key={type.value} value={type.value} >
                    {type.label}
                  </option>
                ))}
              </select>
            </div>
          </form>
        </div>

        <div className="grid sm:grid-cols-1 md:grid-cols-3 lg:grid-cols-4 gap-3">
          {artistsList
            .sort((a, b) => a.id - b.id)
            .map((artist, index) => (
              <ArtistCard key={index} artist={artist} />
            ))}
        </div>
      </div>
    </>
  );
}
