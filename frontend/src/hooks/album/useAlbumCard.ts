import { useAlbumsList } from "@/hooks/";

export default function useAlbumCard({ id }: {id: number}) {
  const { deleteAlbum } = useAlbumsList();

  const handleDelete = () => {
    deleteAlbum(id);
  };

  return { handleDelete };
}