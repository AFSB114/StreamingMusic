import { useGenreCard } from "@/hooks";
import { GenreType } from "@/types";
import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/ui/Card";
import { Edit, Trash2 } from "lucide-react";
import Link from "next/link";

export default function GenreCard({ genre }: { genre: GenreType }) {
  const { handleDelete } = useGenreCard({ id: genre.id });

  return (
    <Card className="">
      <CardHeader className="">
        <CardTitle className="">{genre.name}</CardTitle>
      </CardHeader>

      <CardContent className="">
        <p className="text-gray-600 dark:text-gray-300 line-clamp-3">{genre.description}</p>
      </CardContent>

      <CardFooter className="grid grid-cols-2 p-3 pb-0 gap-2">
        <Link
          href={`/sections/genres/${genre.id}/edit`}
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-2 box-border"
        >
          <Edit className="h-[1em] w-[1em]" />
          <span>Edit</span>
        </Link>
        <button
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-red-600 p-2 hover:cursor-pointer box-border"
          onClick={handleDelete}
        >
          <Trash2 className="h-[1em] w-[1em]" />
          <span>Delete</span>
        </button>
      </CardFooter>
    </Card>
  );
}
