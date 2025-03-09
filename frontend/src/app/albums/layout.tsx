export default function AlbumsLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return (
    <div className="flex-grow md:p-6 p-3 rounded-lg overflow-hidden flex flex-col">
      {children}
    </div>
  );
}
