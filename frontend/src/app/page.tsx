import NavLinks from "@/ui/NavLinks";

export default function Home() {
  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm grid md:grid-cols-3 lg:grid-cols-5 gap-3">
      <NavLinks />
    </div>
  );
}
