"use client";

import { useArtistsList } from "@/hooks";
import type { ArtistType } from "@/types";
import { useState, useEffect, FormEvent } from "react";
import { useParams, useRouter } from "next/navigation";


export default function useEditArtist() {
  const { getArtistById, updateArtist } = useArtistsList();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);

  const [formData, setFormData] = useState<Omit<ArtistType, "id">>({
    name: "",
    biography: "",
    countryOfOrigin: "",
    debutDate: "",
    imageUrl: "https://picsum.photos/seed//300/300",
    type: "",
  });
  const [isLoading, setIsLoading] = useState(false);
  const [isFound, setIsFound] = useState<boolean | null>(null);

  useEffect(() => {
    async function fetchArtist() {
      setIsFound(null); // Indicar que está cargando
  
      const artistData = await getArtistById(id);
      if (artistData) {
        setIsFound(true);
        setFormData({
          name: artistData.name,
          biography: artistData.biography,
          countryOfOrigin: artistData.countryOfOrigin,
          debutDate: artistData.debutDate,
          imageUrl: artistData.imageUrl,
          type: artistData.type,
        });
      } else {
        setIsFound(false);
      }
    }
  
    fetchArtist();
  }, [id, getArtistById]);
  
  // Manejar cambios en los campos del formulario
  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>) => {
    const { name, value } = e.target;

    if (name === "name") {
      const formattedName = value.trim().replace(/\s+/g, "").toLowerCase();
      setFormData((prev) => ({
        ...prev,
        name: value,
        imageUrl: `https://picsum.photos/seed/${formattedName}/300/300`,
      }));
    } else {
      setFormData((prev) => ({
        ...prev,
        [name]: name === "countryOfOrigin" ? value.toUpperCase() : value,
      }));
    }
  };

  // Manejar envío del formulario
  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    setIsLoading(true);

    updateArtist(id, formData);

    setTimeout(() => {
      setIsLoading(false);
      router.push("/sections/artists");
    }, 500);
  };

  const handleReturn = () => {
    router.push("/sections/artists");
  };

  return { formData, isLoading, handleChange, handleSubmit, id, handleReturn, isFound };
}
