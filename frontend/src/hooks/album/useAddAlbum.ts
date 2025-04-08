import { useAlbumsList } from "@/hooks";
import { AlbumType } from "@/types";
import { useRouter } from "next/navigation";
import { ChangeEvent, FormEvent, useState } from "react";

export default function useAddAlbum() {
  const { addAlbum } = useAlbumsList();
  const router = useRouter();

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
  const [isSubmitting, setIsSubmitting] = useState(false);

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
    if (isSubmitting) return;
    if (formData.artistId.id === undefined || formData.recordLabelId.id === undefined) {
      alert("Please select an artist and record label");
      return;
    }
    setIsSubmitting(true);
    setIsLoading(true);


    const newAlbum = {
      title: formData.title,
      artistId: {
        id: formData.artistId.id,
      },
      recordLabelId: {
        id: formData.recordLabelId.id,
      },
      releaseDate: formData.releaseDate,
      description: formData.description === "" ? null : formData.description,
      coverUrl: formData.coverUrl === "" ? null : formData.coverUrl,
      type: formData.type === "" ? null : formData.type,
    };

    try {
      addAlbum(newAlbum);
      setTimeout(() => {
        setIsLoading(false);
        router.push("/sections/albums");
      }, 500);
    } catch (error) {
      console.error(error);
    } finally {
      setIsSubmitting(false);
    }
  }

  return { formData, handleChange, handleSubmit, isLoading };
}
