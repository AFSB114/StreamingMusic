import { ReactNode } from "react";
import { RecordLabelContext } from "@/context/RecordLabelContext";
import { useEntity } from "@/hooks";
import { RecordLabelType } from "@/types";

export const RecordLabelProvider = ({ children }: { children: ReactNode }) => {
  const apiUrl = process.env.NEXT_PUBLIC_API_URL
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<RecordLabelType>(`${apiUrl}/record-label`, "record-labels");

  return (
    <RecordLabelContext.Provider
      value={{
        recordLabelsList: state,
        addRecordLabel: addEntity,
        deleteRecordLabel: deleteEntity,
        updateRecordLabel: updateEntity,
        getRecordLabelById: getEntityById,
        searchRecordLabels: searchEntityBy,
      }}
    >
      {children}
    </RecordLabelContext.Provider>
  );
};