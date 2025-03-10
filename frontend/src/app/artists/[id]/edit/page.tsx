"use client";

import useEditArtist from "@/hooks/useEditArtist";

export default function EditArtistPage() {
  const { id } = useEditArtist();

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm grid md:grid-cols-3 lg:grid-cols-5 gap-3">
      <div className="flex h-full flex-col justify-center gap-3 p-3">
        <h1 className="text-2xl font-bold">Edit Artist { id }</h1>
      </div>
    </div>
  );
}