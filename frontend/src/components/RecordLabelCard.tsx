import { useRecordLabelCard } from "@/hooks";
import { type RecordLabelType } from "@/types";
import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/ui/Card";
import { Edit, ExternalLink, Globe, Trash2 } from "lucide-react";
import Image from "next/image";
import Link from "next/link";

export default function RecordLabelCard({
  recordLabel,
}: {
  recordLabel: RecordLabelType;
}) {
  const { handleDelete } = useRecordLabelCard({ id: recordLabel.id });

  return (
    <Card key={recordLabel.id} className="overflow-hidden">
      <CardHeader className="pb-2">
        <div className="flex flex-col items-center text-center">
          <Image
            src={recordLabel.logoUrl === null ? "" : recordLabel.logoUrl}
            alt={recordLabel.name}
            width={50}
            height={50}
            className="h-16 object-contain mb-4"
          />
          <CardTitle className="">{recordLabel.name}</CardTitle>
        </div>
      </CardHeader>

      <CardContent className="">
        <div className="space-y-3">
          <div className="flex items-center gap-2">
            <Globe size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              {recordLabel.country} • Foundation {" "}
              {recordLabel.foundationDate === null
                ? "Unknown"
                : new Date(recordLabel.foundationDate).getFullYear()}
            </span>
          </div>
          <div className="flex items-center gap-2">
            <ExternalLink size={16} className="text-gray-500" />
            <a
              href={`https://${recordLabel.website}`}
              target="_blank"
              rel="noopener noreferrer"
              className="text-sm text-primary hover:underline"
            >
              {recordLabel.website}
            </a>
          </div>
        </div>
      </CardContent>

      <CardFooter className="grid grid-cols-2 p-3 pb-0 gap-2">
        <Link
          href={`/sections/record-labels/${recordLabel.id}/edit`}
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-2"
        >
          <Edit className="size-4" />
          <span>Edit</span>
        </Link>
        <button
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-red-600 p-2 hover:cursor-pointer"
          onClick={handleDelete}
        >
          <Trash2 className="size-4" />
          <span>Delete</span>
        </button>
      </CardFooter>
    </Card>
  );
}
