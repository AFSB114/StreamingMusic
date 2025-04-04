
import { useArtistsList } from "@/hooks/";

export default function useArtistCard({ id }: {id: number}) {
  const { deleteArtist } = useArtistsList();

  const handleDelete = () => {
    deleteArtist(id);
  };

  return { handleDelete };
}
