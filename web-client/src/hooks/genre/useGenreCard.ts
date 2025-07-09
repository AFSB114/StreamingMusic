import { useGenresList } from "@/hooks/";

export default function useGenreCard({ id }: {id: number}) {
  const { deleteGenre } = useGenresList();

  const handleDelete = () => {
    deleteGenre(id);
  };

  return { handleDelete };
}