import { useParams } from "next/navigation";

export default function useEditArtist() { 

  const params = useParams();
  const id = parseInt(params.id as string);

  return { id };

}