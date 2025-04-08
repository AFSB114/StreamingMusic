"use client";

import { useSongsList } from "@/hooks";
import { SongType } from "@/types";
import { useRouter } from "next/navigation";
import { useState, type ChangeEvent, type FormEvent } from "react";

export default function useAddSong() {
  const { addSong } = useSongsList();
  const router = useRouter();

  const [formData, setFormData] = useState<Omit<SongType, "id">>({
    albumId: {
      id: undefined,
    },
    artistId: {
      id: undefined,
    },
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

      setFormData((prev) => ({
        ...prev,
        [name]: name === "duration" ? parseInt(value) : value,
      }));
  };

  async function handleSubmit(e: FormEvent) {
    e.preventDefault();
    setIsLoading(true);

    const newSong = {
      title: formData.title,
      composer: "",
      duration: formData.duration,
      lyrics: formData.lyrics,
      releaseDate: "",
      trackNumber: 0,
      albumId: null,
      artistId: 1,
      fileUrl: "",
      imageUrl: formData.imageUrl,
    };

    await fetch("http://localhost:8080/songs", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newSong),
    });

    addSong(newSong);

    setTimeout(() => {
      setIsLoading(false);
      router.push("/sections/songs");
    }, 500);
  }

  return { formData, handleChange, handleSubmit, isLoading };
}
