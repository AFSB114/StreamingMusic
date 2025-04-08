"use client";

import { useSongsList } from "@/hooks";
import { SongType } from "@/types";
import { useParams, useRouter } from "next/navigation";
import { useEffect, useState, type ChangeEvent, type FormEvent } from "react";

export default function useEditSong() {
  const { getSongById, updateSong } = useSongsList();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);

  const [formData, setFormData] = useState<Omit<SongType, "id">>({
    albumId: null,
    artistId: {
      id: undefined,
    },
    genreId: null,
    title: "",
    composer: "",
    duration: 0,
    lyrics: "",
    releaseDate: "",
    fileUrl: "songs/.mp3",
    imageUrl: "https://picsum.photos/seed//300/300",
  });
  const [isLoading, setIsLoading] = useState(false);
  const [isFound, setIsFound] = useState<boolean | null>(null);

  useEffect(() => {
    async function fetchSong() {
      setIsFound(null);

      const songData = getSongById(id);
      if (songData) {
        setIsFound(true);
        setFormData({
          albumId: songData.albumId,
          artistId: songData.artistId,
          genreId: songData.genreId,
          title: songData.title,
          composer: songData.composer,
          duration: songData.duration,
          lyrics: songData.lyrics,
          releaseDate: songData.releaseDate,
          fileUrl: songData.fileUrl,
          imageUrl: songData.imageUrl,
        });
      } else {
        setIsFound(false);
      }
    }

    fetchSong();
  }, [id, getSongById]);

  const handleChange = (
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    const { name, value } = e.target;

    if (name === "title") {
      const formattedTitle = value.trim().replace(/\s+/g, "").toLowerCase();
      setFormData((prev) => ({
        ...prev,
        title: value,
        imageUrl: `https://picsum.photos/seed/${formattedTitle}/300/300`,
        fileUrl: `songs/${formattedTitle}.mp3`,
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
      return;
    }

    if (name === "albumId") {
      setFormData((prev) => ({
        ...prev,
        albumId: {
          id: parseInt(value),
        },
      }));
      return;
    }

    if (name === "genreId") {
      setFormData((prev) => ({
        ...prev,
        genreId: {
          id: parseInt(value),
        },
      }));
      return;
    }

    setFormData((prev) => ({
      ...prev,
      [name]: name === "duration" ? parseInt(value) : value,
    }));
  };

  async function handleSubmit(e: FormEvent) {
    e.preventDefault();
    if (formData.artistId.id === undefined) {
      alert("Please select an artist");
      return;
    }
    setIsLoading(true);
    updateSong(id, formData);

    setTimeout(() => {
      setIsLoading(false);
      router.push("/sections/songs");
    }, 500);
  }

  return { formData, handleChange, handleSubmit, isLoading, isFound, id };
}
