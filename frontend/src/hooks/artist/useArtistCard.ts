
import { useArtistsList } from "@/hooks/";
import type { ArtistType } from "@/types";

export default function useArtistCard({ artist }: { artist: ArtistType }) {
  const { deleteArtist } = useArtistsList();

  const handleDelete = () => {
    deleteArtist(artist.id);
  };

  return { handleDelete };
}
