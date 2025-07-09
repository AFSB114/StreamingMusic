import { UserType } from "@/types";
import Badge from "@/ui/Badge";
import {
  Card,
  CardHeader,
  CardTitle,
  CardContent,
  CardFooter,
} from "@/ui/Card";
import { Check, X, Mail, MapPin, Calendar, Edit, Trash2 } from "lucide-react";
import Link from "next/link";
import Image from "next/image";

export default function UserCard({
  user,
}: {
  user: Omit<UserType, "password">;
  }) {
  return (
    <Card key={user.id} className="overflow-hidden">
      <CardHeader className="pb-2">
        <div className="flex items-center gap-4">
          {user.profileImage != null ? (
            <Image
              src={user.profileImage === null ? "" : user.profileImage}
              alt={user.name}
              className="w-16 h-16 rounded-full object-cover"
              height={50}
              width={50}
            />
          ) : (
            <div className="w-16 h-16 rounded-full bg-zinc-500" />
          )}
          <div>
            <CardTitle>{user.name}</CardTitle>
            <div className="flex items-center gap-2 mt-1">
              <Badge
                className={`px-2 py-0 text-xs ${
                  user.active ? "bg-green-600" : "bg-red-600"
                }`}
              >
                {user.active ? (
                  <>
                    <Check size={12} className="mr-1" /> Activo
                  </>
                ) : (
                  <>
                    <X size={12} className="mr-1" /> Inactivo
                  </>
                )}
              </Badge>
            </div>
          </div>
        </div>
      </CardHeader>
      <CardContent>
        <div className="space-y-2">
          <div className="flex items-center gap-2">
            <Mail size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              {user.email}
            </span>
          </div>
          <div className="flex items-center gap-2">
            <MapPin size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              {user.country}
            </span>
          </div>
          <div className="flex items-center gap-2">
            <Calendar size={16} className="text-gray-500" />
            <span className="text-sm text-gray-600 dark:text-gray-300">
              Registrado: {new Date(user.registrationDate).toLocaleDateString()}
            </span>
          </div>
        </div>
      </CardContent>
      {user.active && (
        <CardFooter className="grid grid-cols-2 p-3 pb-0 gap-2">
          <Link
            href={`/sections/users/${user.id}/edit`}
            className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-2 box-border"
          >
            <Edit className="h-[1em] w-[1em]" />
            <span>Edit</span>
          </Link>
          <button className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-red-600 p-2 hover:cursor-pointer box-border">
            <Trash2 className="h-[1em] w-[1em]" />
            <span>Delete</span>
          </button>
        </CardFooter>
      )}
    </Card>
  );
}
