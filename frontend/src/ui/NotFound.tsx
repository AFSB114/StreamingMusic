export default function NotFound({section}: {section: string}) {
  return (
    <div className="min-h-screen flex flex-col items-center justify-center">
      <div className="text-center p-8 max-w-md">
        <h1 className="text-6xl font-bold text-red-500 mb-2">404</h1>
        <h2 className="text-2xl font-semibold mb-4">{section} Not Found</h2>
        <p className="text-zinc-400 mb-8">
        </p>
      </div>
    </div>
  );
}
