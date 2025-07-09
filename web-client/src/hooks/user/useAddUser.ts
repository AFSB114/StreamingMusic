"use client";

import { useState, type FormEvent, type ChangeEvent } from "react";
import useUsersList from "@/hooks/user/useUsersList"; // Ajusta la ruta si es diferente
import { type UserType } from "@/types"; // Ajusta si tu tipo de usuario está en otro archivo
import { useRouter } from "next/navigation";

export default function useAddUser() {
  const { addUser } = useUsersList();
  const router = useRouter();

  const [formData, setFormData] = useState<Omit<UserType, "id" | "active" | "registrationDate">>({
    name: "",
    email: "",
    password: "",
    country: null,
    profileImage: "https://picsum.photos/seed//300/300",
  });
  const [isLoading, setIsLoading] = useState(false);
  const [isSubmitting, setIsSubmitting] = useState(false);

  function handleChange(
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>
  ) {
    const { name, value } = e.target;

    if (value === " ") return; // Evita campos solo con espacios

    if (name === "name") { 
      const formattedName = value.trim().replace(/\s+/g, "").toLowerCase();
      setFormData((prev) => ({
        ...prev,
        name: value,
        profileImage: `https://picsum.photos/seed/${formattedName}/300/300`,
      }));
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

    setIsSubmitting(true);
    setIsLoading(true);

    const newUser = {
      name: formData.name,
      email: formData.email,
      password: formData.password,
      country: formData.country === "" ? null : formData.country,
      profileImage: formData.profileImage === "" ? null : formData.profileImage,
    };

    try {
      await addUser(newUser);
      await new Promise((resolve) => setTimeout(resolve, 500)); // Delay opcional
      // router.push("/sections/users");
    } catch (e) {
      console.error(e);
    } finally {
      setIsSubmitting(false);
      setIsLoading(false);
    }
  }

  return { formData, handleChange, handleSubmit, isLoading };
}
