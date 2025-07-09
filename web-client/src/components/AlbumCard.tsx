import { useAlbumCard } from "@/hooks";
import { AlbumType } from "@/types";
import Badge from "@/ui/Badge";
import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/ui/Card";
import { formatTime } from "@/utils";
import { Calendar, Edit, Timer, Trash2 } from "lucide-react";
import Image from "next/image";
import Link from "next/link";

export default function AlbumCard({ album }: { album: AlbumType }) {
  const { handleDelete } = useAlbumCard({id: album.id});

  return (
    <Card className="overflow-hidden">
      <CardHeader className="">
        <div className="flex flex-col items-center text-center">
          <Image
            src={album.coverUrl === null ? "" : album.coverUrl}
            alt="image"
            width={50}
            height={50}
            className="w-40 h-40 object-cover mb-4 shadow-md"
          />
          <CardTitle className="text-xl">{album.title}</CardTitle>
          <p className="text-sm text-zinc-500">{album.artistId.name}</p>
        </div>
      </CardHeader>

      <CardContent className="">
        <div className="space-y-2">
          <div className="flex items-center justify-center gap-2">
            <Calendar size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              {album.releaseDate === null ? "Unknown" : album.releaseDate}
            </span>
          </div>
          <div className="flex items-center justify-center gap-2">
            <Timer size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              {formatTime(album.totalDuration)}
            </span>
          </div>
          <Badge className="w-full justify-center mt-2 bg-zinc-300">
            {album.recordLabelId.name}
          </Badge>
          <p className="text-sm text-center mt-4 line-clamp-2">
            {album.description}
          </p>
        </div>
      </CardContent>

      <CardFooter className="grid grid-cols-2 p-3 pb-0 gap-2">
        <Link
          href={`/sections/albums/${album.id}/edit`}
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-2 box-border"
        >
          <Edit className="h-[1em] w-[1em]" />
          <span>Edit</span>
        </Link>
        <button className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-red-600 p-2 hover:cursor-pointer box-border" onClick={handleDelete}>
          <Trash2 className="h-[1em] w-[1em]" />
          <span>Delete</span>
        </button>
      </CardFooter>
    </Card>
  );
}
