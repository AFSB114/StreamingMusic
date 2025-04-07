import { useContext } from "react";
import type { RecordLabelContextType } from "@/types";
import { RecordLabelContext } from "@/context/RecordLabelContext";

export default function useRecordLabelsList(): RecordLabelContextType {
  const context = useContext(RecordLabelContext);
  if (!context) {
    throw new Error("useRecordLabel must be used within a RecordLabelProvider");
  }
  return context;
}
