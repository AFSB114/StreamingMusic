"use client";

import { useSongsList } from "@/hooks";
import { SongType } from "@/types";
import { useRouter } from "next/navigation";
import { useState, type ChangeEvent, type FormEvent } from "react";

export default function useAddSong() {
  const { addSong } = useSongsList();
  const router = useRouter();

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
      // console.log(value);
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
    setIsLoading(true);
    if (formData.artistId.id === undefined) {
      setIsLoading(false);
      alert("Please select an artist");
      return;
    }

    const newSong = {
      albumId: (formData.albumId && formData.albumId.id) ? { id: formData.albumId.id } : null,
      artistId: {
        id: formData.artistId.id,
      },
      genreId: (formData.genreId && formData.genreId.id) ? { id: formData.genreId.id } : null,
      title: formData.title,
      composer: formData.composer === "" ? null : formData.composer,
      duration: formData.duration,
      lyrics: formData.lyrics === "" ? null : formData.lyrics,
      releaseDate: formData.releaseDate === "" ? null : formData.releaseDate,
      fileUrl: formData.fileUrl,
      imageUrl: formData.imageUrl,
    };

    // console.log(newSong)
    
    addSong(newSong);

    setTimeout(() => {
      setIsLoading(false);
      router.push("/sections/songs");
    }, 500);
  }

  return { formData, handleChange, handleSubmit, isLoading };
}
