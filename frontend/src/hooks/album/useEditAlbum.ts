import { useAlbumsList } from "@/hooks";
import { AlbumType } from "@/types";
import { useParams, useRouter } from "next/navigation";
import { ChangeEvent, FormEvent, useEffect, useState } from "react";

export default function useAddAlbum() {
  const { getAlbumById, updateAlbum } = useAlbumsList();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);

  const [formData, setFormData] = useState<
    Omit<AlbumType, "id" | "totalDuration">
  >({
    title: "",
    artistId: {
      id: undefined,
    },
    recordLabelId: {
      id: undefined,
    },
    releaseDate: "",
    description: "",
    coverUrl: "https://picsum.photos/seed//300/300",
    type: "",
  });
  const [isLoading, setIsLoading] = useState(false);
  const [isFound, setIsFound] = useState<boolean | null>(false);

  useEffect(() => {
    async function fetchAlbums() {
      setIsFound(null);

      const albumData = getAlbumById(id);
      if (albumData) {
        setIsFound(true);
        setFormData({
          title: albumData.title,
          artistId: {
            id: albumData.artistId.id,
          },
          recordLabelId: {
            id: albumData.recordLabelId.id,
          },
          releaseDate: albumData.releaseDate,
          description: albumData.description,
          coverUrl: albumData.coverUrl,
          type: albumData.type,
        });
      } else {
        setIsFound(false);
      }
    }

    fetchAlbums();
  }, [id, getAlbumById]);

  function handleChange(
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>
  ) {
    const { name, value } = e.target;

    if (value === " ") return;

    if (name === "title") {
      const formattedName = value.trim().replace(/\s+/g, "").toLowerCase();
      setFormData((prev) => ({
        ...prev,
        title: value,
        coverUrl: `https://picsum.photos/seed/${formattedName}/300/300`,
      }));
      return;
    }

    if (name === "artistId") {
      setFormData((prev) => ({
        ...prev,
        artistId: {
          id: parseInt(value),
        },
      }));
      console.log(value);
      return;
    }

    if (name === "recordLabeId") {
      setFormData((prev) => ({
        ...prev,
        recordLabelId: {
          id: parseInt(value),
        },
      }));
      console.log(value);
      return;
    }

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  }

  async function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setIsLoading(!isLoading);

    try {
      updateAlbum(id, formData);
      setTimeout(() => {
        setIsLoading(false);
        router.push("/sections/albums");
      }, 500);
    } catch (error) {
      console.error("Error:", error);
      setIsLoading(false);
    }
  }

  return { formData, handleChange, handleSubmit, isLoading, isFound, id };
}
