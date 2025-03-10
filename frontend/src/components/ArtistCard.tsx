import Card from "@/ui/Card";
import Image from "next/image";
import { Edit, Trash2 } from "lucide-react";
import Link from "next/link";
import useArtistCard from "@/hooks/useArtistCard";

import { type ArtistType } from "@/types";

export default function ArtistCard({ artist }: { artist: ArtistType }) {
  const { handleDelete } = useArtistCard({ artist });

  return (
    <Card className="relative overflow-hidden w-">
      <div className="absolute inset-0 bg-gradient-to-t from-background to-transparent z-10" />
      <Image
        src={artist.image_url}
        alt="Artist"
        width={300}
        height={300}
        className="absolute inset-0 w-full h-full object-cover"
      />
      <div className="relative z-20">
        <div className="pt-4 px-3">
          <div className="flex justify-center">
            <div className="text-xs font-bold bg-zinc-500/50 rounded-full w-20 h-20"></div>
          </div>
        </div>
        <div className="text-center mt-2 px-3">
          <div className="text-lg font-bold text-white">{ artist.name }</div>
          <div className="text-xs text-white/80 pb-2">{artist.country_of_origin} • {artist.type}</div>
          <hr className="border-zinc-500/50 w-full" />
          <div className="text-xs pt-2">{artist.biography}</div>
          <div className="mt-2">
            <div className="text-xs bg-white/20 hover:bg-white/30 w-full p-1 rounded-md">
              2.4M Followers
            </div>
          </div>
        </div>
        <div className="grid grid-cols-2 p-3 pb-0 gap-2">
        <Link
          href={`/artists/${artist.id}/edit`}
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-2"
        >
          <Edit className="h-4 w-4" />
          <span>Edit</span>
        </Link>
        <button
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-red-600 p-2 hover:cursor-pointer"
          onClick={handleDelete}
        >
          <Trash2 className="h-4 w-4" />
          <span>Delete</span>
        </button>
      </div>
      </div>
    </Card>
  );
}
