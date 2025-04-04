import Card from "@/ui/Card";
import Image from "next/image";
import { Edit, Trash2 } from "lucide-react";
import Link from "next/link";
import { useArtistCard } from "@/hooks";
import { type ArtistType } from "@/types";

export default function ArtistCard({ artist }: { artist: ArtistType }) {
  const { handleDelete } = useArtistCard({ id: artist.id });

  return (
    <Card className="relative w-full overflow-hidden">
      <div className="h-full flex flex-col">
        {/* Imagen de fondo con gradiente */}
        <div className="absolute inset-0">
          <Image
            src={artist.imageUrl}
            alt="Artist"
            fill
            className="object-cover"
          />
          <div className="absolute inset-0 bg-gradient-to-t from-background to-transparent" />
        </div>

        {/* Contenido sobre la imagen */}
        <div className="relative z-20 text-white flex flex-col flex-grow">
          {/* Avatar circular */}
          <div className="pt-4 px-3 flex justify-center">
            <div className="text-xs font-bold bg-zinc-500/50 rounded-full w-20 h-20 flex items-center justify-center">
              {artist.name.charAt(0)}
            </div>
          </div>

          {/* Información del artista */}
          <div className="text-center mt-2 px-3 flex-grow flex flex-col">
            <div className="text-lg font-bold">{artist.name}</div>
            <div className="text-xs text-white/80 pb-2">
              {artist.countryOfOrigin} • {artist.type}
            </div>

            <hr className="border-zinc-500/50 w-full" />

            {/* Biografía truncada */}
            <div className="text-xs pt-2 line-clamp-3 flex-grow">
              {artist.biography}
            </div>

            {/* Seguidores */}
            <div className="mt-2">
              <div className="text-xs bg-white/20 hover:bg-white/30 w-full p-1 rounded-md text-center">
                2.4M Followers
              </div>
            </div>
          </div>

          {/* Acciones */}
          <div className="grid grid-cols-2 p-3 pb-0 gap-2">
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
          </div>
        </div>
      </div>
    </Card>
  );
}
