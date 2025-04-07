"use client";

import { type RecordLabelType } from "@/types";
import { useRouter } from "next/navigation";
import { useState } from "react";
import { useRecordLabelsList } from "@/hooks";

export default function useAddRecordLabel() {
  const { addRecordLabel } = useRecordLabelsList();
  const router = useRouter();

  const [formData, setFormData] = useState<Omit<RecordLabelType, "id">>({
    name: "",
    country: "",
    foundationDate: "",
    logoUrl: "https://picsum.photos/seed//300/300",
    website: "https://.com",
  });
  const [isLoading, setIsLoading] = useState(false);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    if (value == " ") return;

    if (name === "name") {
      const formattedName = value.trim().replace(/\s+/g, "").toLowerCase();
      setFormData((prev) => ({
        ...prev,
        name: value,
        logoUrl: `https://picsum.photos/seed/${formattedName}/300/300`,
        website: `https://${formattedName}.com`,
      }));
    } else {
      setFormData((prev) => ({
        ...prev,
        [name]: value,
      }));
    }
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setIsLoading(!isLoading);

    const newRecordLabel = {
      name: formData.name,
      country: formData.country === "" ? null : formData.country,
      foundationDate:
        formData.foundationDate === "" ? null : formData.foundationDate,
      logoUrl: formData.logoUrl === "" ? null : formData.logoUrl,
      website: formData.website === "" ? null : formData.website,
    };

    try {
      await addRecordLabel(newRecordLabel);
      setTimeout(() => {
        setIsLoading(false);
        router.push("/sections/record-labels");
      });
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return { formData, handleChange, handleSubmit, isLoading };
}
