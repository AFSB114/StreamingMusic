"use client";

import { Heart, Music, Edit, Trash2 } from "lucide-react";
import Image from "next/image";
import { type SongType } from "@/types";
import useSongCard from "@/hooks/song/useSongCard";
import Link from "next/link";
import Card from "@/ui/Card";

export default function SongCard({ song }: { song: SongType }) {
  const { handleLike, handleDelete, liked, formatDuration } = useSongCard({
    song,
  });

  return (
    <Card className="w-full overflow-hidden">
      <div className="h-full flex flex-col">
        {/* Image Container */}
        <div className="relative aspect-square w-full">
          <Image
            src={song.image_url}
            alt="Album cover"
            fill
            className="object-cover"
          />
        </div>

        {/* Header */}
        <div className="p-3">
          <div className="flex justify-between items-center">
            <div className="overflow-hidden">
              <h3 className="text-base truncate">{song.title}</h3>
              <p className="text-xs truncate">{song.lyrics}</p>
            </div>
            <button
              type="button"
              onClick={handleLike}
              className={`flex-shrink-0 flex items-center gap-2 rounded-full p-2 transition-all duration-150 ${
                liked ? "bg-red-500/80 ease-in" : "ease-out"
              }`}
            >
              <Heart
                className={`h-5 w-5 active:scale-150 transition-all duration-150 ${
                  liked ? "text-white" : "text-current"
                }`}
              />
              <span className="sr-only">Like</span>
            </button>
          </div>
        </div>

        {/* Footer */}
        <div className="p-3 pt-0 text-xs text-muted-foreground">
          <div className="flex items-center gap-1">
            <Music className="h-3 w-3 flex-shrink-0" />
            <span className="truncate">{formatDuration(song.duration)}</span>
          </div>
        </div>

        {/* Actions */}
        <div className="grid grid-cols-2 p-3 pb-0 gap-2">
          <Link
            href={`/sections/songs/${song.id}/edit`}
            className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-2 box-border"
          >
            <Edit className="h-[1em] w-[1em]" />
            <span>Edit</span>
          </Link>

          <button
            className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-red-600 p-2 hover:cursor-pointer box-border"
            onClick={handleDelete}
          >
            <Trash2 className="h-[1em] w-[1em]" />
            <span>Delete</span>
          </button>
        </div>
      </div>
    </Card>
  );
}
