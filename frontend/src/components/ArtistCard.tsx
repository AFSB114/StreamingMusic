import {
  Card,
  CardFooter,
  CardHeader,
  CardTitle,
  CardContent,
} from "@/ui/Card";
import Image from "next/image";
import { Edit, Trash2 } from "lucide-react";
import Link from "next/link";
import { useArtistCard } from "@/hooks";
import { type ArtistType } from "@/types";

export default function ArtistCard({ artist }: { artist: ArtistType }) {
  const { handleDelete } = useArtistCard({ id: artist.id });

  return (
    <Card className="relative w-full overflow-hidden">
      
        <CardHeader className="pb-2">
          <div className="flex items-center gap-4">
            <Image
              src={artist.imageUrl || "/placeholder.svg"}
              alt={artist.name}
              width={50}
              height={50}
              className="w-16 h-16 rounded-full object-cover"
            />
            <div>
              <CardTitle className="">{artist.name}</CardTitle>
              <p className="text-sm text-gray-500">
                {artist.type} • {artist.countryOfOrigin}
              </p>
            </div>
          </div>
        </CardHeader>

        <CardContent className="">
          <div className="space-y-2">
            <p className="text-sm text-gray-600 dark:text-gray-300">
              <span className="font-semibold">Debut:</span> {artist.debutDate}
            </p>
            <p className="text-sm line-clamp-3">{artist.biography}</p>
          </div>
        </CardContent>

        <CardFooter className="grid grid-cols-2 p-3 pb-0 gap-2">
          <Link
            href={`/sections/artists/${artist.id}/edit`}
            className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-2"
          >
            <Edit className="size-4" />
            <span>Edit</span>
          </Link>
          <button
            className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-red-600 p-2 hover:cursor-pointer"
            onClick={handleDelete}
          >
            <Trash2 className="size-4" />
            <span>Delete</span>
          </button>
        </CardFooter>
      
    </Card>
  );
}
