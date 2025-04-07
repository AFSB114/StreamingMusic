"use client";

import { useRecordLabelsList } from "@/hooks";
import { RecordLabelType } from "@/types";
import { useParams, useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function useEditRecordLabel() {
  const { getRecordLabelById, updateRecordLabel } = useRecordLabelsList();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);

    const [formData, setFormData] = useState<Omit<RecordLabelType, "id">>({
      name: "",
      country: "",
      foundationDate: "",
      logoUrl: "https://picsum.photos/seed//300/300",
      website: "https://.com",
    });
  const [isLoading, setIsLoading] = useState(false);
  const [isFound, setIsFound] = useState<boolean | null>(null);

  useEffect(() => {
    async function fetchRecordLabels() {
      setIsFound(null)

      const recordLabelData = getRecordLabelById(id)
      if (recordLabelData) {
        setIsFound(true)
        setFormData({
          name: recordLabelData.name,
          country: recordLabelData.country,
          foundationDate: recordLabelData.foundationDate,
          logoUrl: recordLabelData.logoUrl,
          website: recordLabelData.website
        })
      } else {
        setIsFound(false)
      }
    }

    fetchRecordLabels()
  }, [id, getRecordLabelById])

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

    try {
      updateRecordLabel(id, formData);
      setTimeout(() => {
        setIsLoading(false);
        router.push("/sections/record-labels");
      }, 500);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleReturn = () => {
    router.push("/sections/record-labels");
  };

  return { formData, isLoading, handleChange, handleSubmit, id, handleReturn, isFound }
}
