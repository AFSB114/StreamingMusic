"use client";

import { useSongCard } from "@/hooks";
import { type SongType } from "@/types";
import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/ui/Card";
import { formatTime } from "@/utils";
import { Calendar, Clock, Edit, Music, Trash2 } from "lucide-react";
import Image from "next/image";
import Link from "next/link";

export default function SongCard({ song }: { song: SongType }) {
  const { handleDelete } = useSongCard();

  return (
    <Card className="overflow-hidden">
      <CardHeader className="pb-2">
        <div className="flex items-center gap-4">
          <Image
            src={song.imageUrl || ""}
            alt={song.title}
            className="w-16 h-16 rounded object-cover"
          />
          <div>
            <CardTitle className="">{song.title}</CardTitle>
            <p className="text-sm text-gray-500">{song.artistId.name}</p>
          </div>
        </div>
      </CardHeader>
      <CardContent className="">
        <div className="space-y-2">
          <div className="flex items-center gap-2">
            <Music size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              Álbum: {song.albumId.title}
            </span>
          </div>
          <div className="flex items-center gap-2">
            <Clock size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              {formatTime(song.duration)}
            </span>
          </div>
          <div className="flex items-center gap-2">
            <Calendar size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              {new Date(song.releaseDate).toLocaleDateString()}
            </span>
          </div>
        </div>
      </CardContent>
      <CardFooter className="grid grid-cols-2 p-3 pb-0 gap-2">
        <Link
          href={`/sections/albums/${song.id}/edit`}
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
      </CardFooter>
    </Card>
  );
}
