import { useRecordLabelsList } from "@/hooks";

export default function useRecordLabelCard({ id }: { id: number }) {
  const { deleteRecordLabel } = useRecordLabelsList();

  const handleDelete = () => {
    deleteRecordLabel(id);
  };

  return { handleDelete };
}
